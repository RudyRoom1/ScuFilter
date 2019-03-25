package skuJsonObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

public class Corporate implements Serializable {

    private final static long serialVersionUID = -1186636914360979786L;
    @SerializedName("Quantity")
    @Expose
    private Integer quantity;
    @SerializedName("MinOrderQty")
    @Expose
    private Integer minOrderQty;
    @SerializedName("MinETA")
    @Expose
    private Integer minETA;
    @SerializedName("MaxETA")
    @Expose
    private Integer maxETA;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Corporate withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Integer getMinOrderQty() {
        return minOrderQty;
    }

    public void setMinOrderQty(Integer minOrderQty) {
        this.minOrderQty = minOrderQty;
    }

    public Corporate withMinOrderQty(Integer minOrderQty) {
        this.minOrderQty = minOrderQty;
        return this;
    }

    public Integer getMinETA() {
        return minETA;
    }

    public void setMinETA(Integer minETA) {
        this.minETA = minETA;
    }

    public Corporate withMinETA(Integer minETA) {
        this.minETA = minETA;
        return this;
    }

    public Integer getMaxETA() {
        return maxETA;
    }

    public void setMaxETA(Integer maxETA) {
        this.maxETA = maxETA;
    }

    public Corporate withMaxETA(Integer maxETA) {
        this.maxETA = maxETA;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("quantity", quantity).append("minOrderQty", minOrderQty).append("minETA", minETA).append("maxETA", maxETA).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(maxETA).append(minETA).append(quantity).append(minOrderQty).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Corporate) == false) {
            return false;
        }
        Corporate rhs = ((Corporate) other);
        return new EqualsBuilder().append(maxETA, rhs.maxETA).append(minETA, rhs.minETA).append(quantity, rhs.quantity).append(minOrderQty, rhs.minOrderQty).isEquals();
    }

}