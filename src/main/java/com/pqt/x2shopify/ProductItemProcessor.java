package com.pqt.x2shopify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class ProductItemProcessor implements ItemProcessor<XProduct, ShopifyProduct> {

	private static final Logger log = LoggerFactory.getLogger(BatchConfiguration.class);
	
	@Override
	public ShopifyProduct process(XProduct item) throws Exception {
		log.info("process: enter");
		final ShopifyProduct transformedProduct = new ShopifyProduct();
		
		transformedProduct.setHandle(item.getProductId());
		transformedProduct.setTitle(item.getProductName());
		transformedProduct.setBodyHtml("BodyHtml");
		transformedProduct.setVendor("Vendor");
		transformedProduct.setStandardizedProductType("StandardizedProductType");
		transformedProduct.setCustomProductType("CustomProductType");
		transformedProduct.setTags("Tags");
		transformedProduct.setPublished("Published");
		transformedProduct.setOption1Name("Option1Name");
		transformedProduct.setOption1Value("Option1Value");
		transformedProduct.setOption2Name("Option2Name");
		transformedProduct.setOption2Value("Option2Value");
		transformedProduct.setOption3Name("Option3Name");
		transformedProduct.setOption3Value("Option3Value");
		transformedProduct.setVariantSku("VariantSku");
		transformedProduct.setVariantGrams("VariantGrams");
		transformedProduct.setVariantInventoryTracker("VariantInventoryTracker");
		transformedProduct.setVariantInventoryQty("VariantInventoryQty");
		transformedProduct.setVariantInventoryPolicy("VariantInventoryPolicy");
		transformedProduct.setVariantFulfillmentService("VariantFulfillmentService");
		transformedProduct.setVariantPrice("VariantPrice");
		transformedProduct.setVariantCompareAtPrice("VariantCompareAtPrice");
		transformedProduct.setVariantRequiresShipping("VariantRequiresShipping");
		transformedProduct.setVariantTaxable("VariantTaxable");
		transformedProduct.setVariantBarcode("VariantBarcode");
		transformedProduct.setImageSrc("ImageSrc");
		transformedProduct.setImagePosition("ImagePosition");
		transformedProduct.setImageAltText("ImageAltText");
		transformedProduct.setGiftCard("GiftCard");
		transformedProduct.setSeoTitle("SeoTitle");
		transformedProduct.setSeoDescription("SeoDescription");
		transformedProduct.setGoogleProductCategory("GoogleProductCategory");
		transformedProduct.setGender("Gender");
		transformedProduct.setAgeGroup("AgeGroup");
		transformedProduct.setMpn("Mpn");
		transformedProduct.setAdWordsGrouping("AdWordsGrouping");
		transformedProduct.setAdWordsLabels("AdWordsLabels");
		transformedProduct.setCondition("Condition");
		transformedProduct.setCustomProduct("CustomProduct");
		transformedProduct.setCustomLabel0("CustomLabel0");
		transformedProduct.setCustomLabel1("CustomLabel1");
		transformedProduct.setCustomLabel2("CustomLabel2");
		transformedProduct.setCustomLabel3("CustomLabel3");
		transformedProduct.setCustomLabel4("CustomLabel4");
		transformedProduct.setVariantImage("VariantImage");
		transformedProduct.setVariantWeightUnit("VariantWeightUnit");
		transformedProduct.setVariantTaxCode("VariantTaxCode");
		transformedProduct.setCostPerItem("CostPerItem");
		transformedProduct.setPriceInternational("PriceInternational");
		transformedProduct.setCompareAtPriceInternational("CompareAtPriceInternational");
		transformedProduct.setStatus("Status");
		
		return transformedProduct;
	}

}
