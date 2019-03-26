package skuJsonObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TableObject implements Serializable {

    private final static long serialVersionUID = 1623894804250846516L;
    @SerializedName("Banner")
    @Expose
    private String banner;
    @SerializedName("Store")
    @Expose
    private String store;
    @SerializedName("SKU")
    @Expose
    private String sKU;
    @SerializedName("CheckDigit")
    @Expose
    private String checkDigit;
    @SerializedName("Product")
    @Expose
    private String product;
    @SerializedName("Price")
    @Expose
    private Double price;
    @SerializedName("Quantity")
    @Expose
    private Integer quantity;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("Messages")
    @Expose
    private Messages messages;
    @SerializedName("PartNumber")
    @Expose
    private String partNumber;
    @SerializedName("IsOnline")
    @Expose
    private IsOnline isOnline;
    @SerializedName("Corporate")
    @Expose
    private Corporate corporate;

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public TableObject withBanner(String banner) {
        this.banner = banner;
        return this;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public TableObject withStore(String store) {
        this.store = store;
        return this;
    }

    public String getSKU() {
        return sKU;
    }

    public void setSKU(String sKU) {
        this.sKU = sKU;
    }

    public TableObject withSKU(String sKU) {
        this.sKU = sKU;
        return this;
    }

    public String getCheckDigit() {
        return checkDigit;
    }

    public void setCheckDigit(String checkDigit) {
        this.checkDigit = checkDigit;
    }

    public TableObject withCheckDigit(String checkDigit) {
        this.checkDigit = checkDigit;
        return this;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public TableObject withProduct(String product) {
        this.product = product;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TableObject withPrice(Double price) {
        this.price = price;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public TableObject withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TableObject withDescription(String description) {
        this.description = description;
        return this;
    }

    public Messages getMessages() {
        return messages;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    public TableObject withMessages(Messages messages) {
        this.messages = messages;
        return this;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public TableObject withPartNumber(String partNumber) {
        this.partNumber = partNumber;
        return this;
    }

    public IsOnline getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(IsOnline isOnline) {
        this.isOnline = isOnline;
    }

    public TableObject withIsOnline(IsOnline isOnline) {
        this.isOnline = isOnline;
        return this;
    }

    public Corporate getCorporate() {
        return corporate;
    }

    public void setCorporate(Corporate corporate) {
        this.corporate = corporate;
    }

    public TableObject withCorporate(Corporate corporate) {
        this.corporate = corporate;
        return this;
    }

    public String getFilteredListByQuantity(List<TableObject> tableObjectList, String paramOfFilter){
        List<String> filteredSku = new ArrayList<>();

        for (TableObject entity: tableObjectList) {
            if (entity.getQuantity().toString().equals(paramOfFilter)){
                filteredSku.add(entity.getSKU());
            }
        }
        return String.join(",\n", filteredSku);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("banner", banner).append("store", store).append("sKU", sKU).append("checkDigit", checkDigit).append("product", product).append("price", price).append("quantity", quantity).append("description", description).append("messages", messages).append("partNumber", partNumber).append("isOnline", isOnline).append("corporate", corporate).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sKU).append(store).append(checkDigit).append(messages).append(isOnline).append(product).append(corporate).append(price).append(description).append(quantity).append(partNumber).append(banner).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof TableObject)) {
            return false;
        }
        TableObject rhs = ((TableObject) other);
        return new EqualsBuilder().append(sKU, rhs.sKU).append(store, rhs.store).append(checkDigit, rhs.checkDigit).append(messages, rhs.messages).append(isOnline, rhs.isOnline).append(product, rhs.product).append(corporate, rhs.corporate).append(price, rhs.price).append(description, rhs.description).append(quantity, rhs.quantity).append(partNumber, rhs.partNumber).append(banner, rhs.banner).isEquals();
    }

}