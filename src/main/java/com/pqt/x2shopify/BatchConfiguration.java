package com.pqt.x2shopify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	private static final Logger log = LoggerFactory.getLogger(BatchConfiguration.class);
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<XProduct> reader() {
    	log.info("reader: enter");
        return new FlatFileItemReaderBuilder<XProduct>()
                .name("reader")
                .resource(new ClassPathResource("x-products.csv"))
                .delimited()
                .names(new String[]{"productId", "productName"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<XProduct>() {
                    {
                        setTargetType(XProduct.class);
                    }
                })
                .build();
    }

    private Resource outputResource = new FileSystemResource("output/outputData.csv");
    
    @Bean
    public FlatFileItemWriter<ShopifyProduct> writer() {
    	log.info("writer: enter");
		
    	FlatFileItemWriter<ShopifyProduct> writer = new FlatFileItemWriter<>();

		writer.setResource(outputResource);

		writer.setAppendAllowed(true);

		writer.setLineAggregator(new DelimitedLineAggregator<ShopifyProduct>() {
			{
				setDelimiter(",");
				setFieldExtractor(new BeanWrapperFieldExtractor<ShopifyProduct>() {
					{
						setNames(new String[] {
								"handle",
								"title",
								"bodyHtml",
								"vendor",
								"standardizedProductType",
								"customProductType",
								"tags",
								"published",
								"option1Name",
								"option1Value",
								"option2Name",
								"option2Value",
								"option3Name",
								"option3Value",
								"variantSku",
								"variantGrams",
								"variantInventoryTracker",
								"variantInventoryQty",
								"variantInventoryPolicy",
								"variantFulfillmentService",
								"variantPrice",
								"variantCompareAtPrice",
								"variantRequiresShipping",
								"variantTaxable",
								"variantBarcode",
								"imageSrc",
								"imagePosition",
								"imageAltText",
								"giftCard",
								"seoTitle",
								"seoDescription",
								"googleProductCategory",
								"gender",
								"ageGroup",
								"mpn",
								"adWordsGrouping",
								"adWordsLabels",
								"condition",
								"customProduct",
								"customLabel0",
								"customLabel1",
								"customLabel2",
								"customLabel3",
								"customLabel4",
								"variantImage",
								"variantWeightUnit",
								"variantTaxCode",
								"costPerItem",
								"priceInternational",
								"compareAtPriceInternational",
								"status"
								});
					}
				});
			}
		});

		return writer;
    }
    
	@Bean
	public ProductItemProcessor processor() {
		log.info("processor: enter");
		return new ProductItemProcessor();
	}
	
	@Bean
	public Job importProductJob() {
		log.info("importProductJob: enter");
	  return jobBuilderFactory.get("importProductJob")
	    .incrementer(new RunIdIncrementer())
	    .listener(new JobResultListener())
	    .flow(step1())
	    .end()
	    .build();
	}

	@Bean
	public Step step1() {
		log.info("step1: enter");
	  return stepBuilderFactory.get("step1")
	    .<XProduct, ShopifyProduct>chunk(10)
	    .reader(reader())
	    .processor(processor())
	    .writer(writer())
	    .listener(new StepResultListener())
	    .build();
	}
}
