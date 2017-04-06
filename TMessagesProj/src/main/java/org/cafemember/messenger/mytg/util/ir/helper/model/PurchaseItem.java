package org.cafemember.messenger.mytg.util.ir.helper.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Shima Zeinali
 * @author Khaled Bakhtiari
 * @since 2015-02-14
 */
public class PurchaseItem {

    public final JSONObject jsonObject;
    /**
     * id of buy order
     */
    public String orderId;
    /**
     * package name of your app
     */
    public String packageName;
    /**
     * id of buy product
     */
    public String productId;
    /**
     * time of purchase product
     */
    public String purchaseTime;
    /**
     * id for consume product
     */
    public String purchaseToken;
    /**
     * to verify the buy
     */
    public String developerPayload;

    /**
     * creates an instance of BuyData with the given parameters.<br>
     * gets string buy data and convert to json object
     *
     * @param jsonBuyData contains data of buy
     */
    public PurchaseItem(String jsonBuyData) throws JSONException {
        jsonObject = new JSONObject(jsonBuyData);
        orderId = jsonObject.getString("orderId");
        packageName = jsonObject.getString("packageName");
        productId = jsonObject.getString("productId");
        purchaseTime = jsonObject.getString("purchaseTime");
        purchaseToken = jsonObject.getString("purchaseToken");
        developerPayload = jsonObject.getString("developerPayload");
    }

    /**
     * use this method to create a new instance of {@link PurchaseItem}
     * when you're sure that your json is valid
     *
     * @param jsonBuyData contains data of buy
     * @return
     */
    public static PurchaseItem newInstanceNoException(String jsonBuyData) {
        try {
            return new PurchaseItem(jsonBuyData);
        } catch (JSONException e) {
            e.printStackTrace();
            throw new RuntimeException("we expect the jsonBuyData to be valid");
        }
    }
}