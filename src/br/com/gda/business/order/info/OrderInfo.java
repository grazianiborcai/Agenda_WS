package br.com.gda.business.order.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class OrderInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codOrder;
	public long codPerson;
	public long codUser;
	public long codSnapshot;
	public String codOrderExt;
	public long codCustomer;	
	public String codOrderStatus;
	public LocalDateTime lastChanged;
	public String codLanguage;
	public List<CartSnapInfo> cartSnaps;
	public UserSnapInfo userSnap;
	
	
	public OrderInfo() {
		codOwner = DefaultValue.number();
		codOrder = DefaultValue.number();
		codPerson = DefaultValue.number();
		codUser = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codLanguage = DefaultValue.language();
		cartSnaps = new ArrayList<>();
		userSnap = DefaultValue.object();
	}
	
	
	
	public static OrderInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrderInfo.class);
	}
	
	
	
	public static List<OrderInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrderInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		OrderInfo deepCopy = (OrderInfo) super.clone();
		deepCopy.cartSnaps = cloneCartItems(deepCopy.cartSnaps);
		
		return deepCopy;
	}
	
	
	
	private List<CartSnapInfo> cloneCartItems(List<CartSnapInfo> cartItems) throws CloneNotSupportedException {
		if (cartItems == null)
			return null;
		
		List<CartSnapInfo> deepCartItems = new ArrayList<>();
		
		for (CartSnapInfo eachItem : cartItems) {
			CartSnapInfo cloneItem = (CartSnapInfo) eachItem.clone();
			deepCartItems.add(cloneItem);
		}
		
		return deepCartItems;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner   ^ (codOwner   >>> 32));
		result = result * 31 + (int) (codOrder   ^ (codOrder   >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OrderInfo))
			return false;
		
		
		OrderInfo obj = (OrderInfo) o;		
		return (codOwner   == obj.codOwner && 
				codOrder   == obj.codOrder		);
	}	
}
