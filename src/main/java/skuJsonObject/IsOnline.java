package skuJsonObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

public class IsOnline implements Serializable {

    private final static long serialVersionUID = 946670028730774691L;
    @SerializedName("Active")
    @Expose
    private String active;
    @SerializedName("Exclusive")
    @Expose
    private String exclusive;
    @SerializedName("Sellable")
    @Expose
    private String sellable;
    @SerializedName("Orderable")
    @Expose
    private String orderable;
    @SerializedName("StoreClearance")
    @Expose
    private String storeClearance;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public IsOnline withActive(String active) {
        this.active = active;
        return this;
    }

    public String getExclusive() {
        return exclusive;
    }

    public void setExclusive(String exclusive) {
        this.exclusive = exclusive;
    }

    public IsOnline withExclusive(String exclusive) {
        this.exclusive = exclusive;
        return this;
    }

    public String getSellable() {
        return sellable;
    }

    public void setSellable(String sellable) {
        this.sellable = sellable;
    }

    public IsOnline withSellable(String sellable) {
        this.sellable = sellable;
        return this;
    }

    public String getOrderable() {
        return orderable;
    }

    public void setOrderable(String orderable) {
        this.orderable = orderable;
    }

    public IsOnline withOrderable(String orderable) {
        this.orderable = orderable;
        return this;
    }

    public String getStoreClearance() {
        return storeClearance;
    }

    public void setStoreClearance(String storeClearance) {
        this.storeClearance = storeClearance;
    }

    public IsOnline withStoreClearance(String storeClearance) {
        this.storeClearance = storeClearance;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("active", active).append("exclusive", exclusive).append("sellable", sellable).append("orderable", orderable).append("storeClearance", storeClearance).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(orderable).append(storeClearance).append(sellable).append(exclusive).append(active).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IsOnline) == false) {
            return false;
        }
        IsOnline rhs = ((IsOnline) other);
        return new EqualsBuilder().append(orderable, rhs.orderable).append(storeClearance, rhs.storeClearance).append(sellable, rhs.sellable).append(exclusive, rhs.exclusive).append(active, rhs.active).isEquals();
    }

}