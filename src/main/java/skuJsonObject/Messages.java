package skuJsonObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

public class Messages implements Serializable {

    private final static long serialVersionUID = 2453339123712269224L;
    @SerializedName("Warranty")
    @Expose
    private String warranty;

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public Messages withWarranty(String warranty) {
        this.warranty = warranty;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("warranty", warranty).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(warranty).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Messages) == false) {
            return false;
        }
        Messages rhs = ((Messages) other);
        return new EqualsBuilder().append(warranty, rhs.warranty).isEquals();
    }

}