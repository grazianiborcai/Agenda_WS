package br.com.gda.business.orderSnapshot.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class OrdnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codSnapshot;	
	public long codOrder;
	public String codOrderExt;	
	public long codCustomer;
	public long codCustomerSnapshot;
	public long codUser;
	public long codUserSnapshot;	
	public long codAddressShip;
	public long codAddressShipSnapshot;
	public long codAddressInvoice;
	public long codAddressInvoiceSnapshot;
	public long codPhoneShip;
	public long codPhoneShipSnapshot;
	public long codPhoneInvoice;
	public long codPhoneInvoiceSnapshot;	
	public double itemTotal;
	public double feeService;
	public double grandTotal;	
	public String codCurr;
	public String txtCurr;
	public char codFeeCateg;
	public String txtFeeCateg;
	public String codOrderStatus;
	public String txtOrderStatus;
	public long codPayOrder;
	public int codPayPartner;
	public String statusOrderPartner;
	public String statusPaymentPartner;
	public LocalDateTime lastChanged;
	public LocalDateTime createdOn;
	public long lastChangedBy;
	public long createdBy;
	public String username;
	public List<OrderemInfo> orderms;
	
	
	public OrdnapInfo() {
		super(OrdnapInfo.class);
		
		codOwner = DefaultValue.number();	
		codSnapshot = DefaultValue.number();	
		codOrder = DefaultValue.number();				
		codCustomer = DefaultValue.number();
		codCustomerSnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserSnapshot = DefaultValue.number();		
		codAddressShip = DefaultValue.number();
		codAddressShipSnapshot = DefaultValue.number();
		codAddressInvoice = DefaultValue.number();
		codAddressInvoiceSnapshot = DefaultValue.number();
		codPhoneShip = DefaultValue.number();
		codPhoneShipSnapshot = DefaultValue.number();
		codPhoneInvoice = DefaultValue.number();
		codPhoneInvoiceSnapshot = DefaultValue.number();		
		itemTotal = DefaultValue.number();
		feeService = 0;
		codFeeCateg = DefaultValue.character();
		grandTotal = DefaultValue.number();
		codPayOrder = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();	
		orderms = DefaultValue.list();
	}
	
	
	
	public static OrdnapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrdnapInfo.class);
	}
	
	
	
	public static List<OrdnapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrdnapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		OrdnapInfo deepCopy = (OrdnapInfo) super.clone();
		
		deepCopy.lastChanged = lastChanged;
		deepCopy.orderms = cloneOrderems(orderms);
		
		return deepCopy;
	}
	
	
	
	private List<OrderemInfo> cloneOrderems(List<OrderemInfo> recordInfos) throws CloneNotSupportedException {
		List<OrderemInfo> results = new ArrayList<>();
		
		if (recordInfos == null)
			return null;
		
		for (OrderemInfo eachRecord : recordInfos) {
			OrderemInfo clonedRecord = (OrderemInfo) eachRecord.clone();
			results.add(clonedRecord);
		}
		
		
		return results;
	}	
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 		^ (codOwner 	>>> 32));
		result = result * 31 + (int) (codSnapshot 	^ (codSnapshot 	>>> 32));
		result = result * 31 + (int) (codOrder 		^ (codOrder 	>>> 32));
		result = result * 31 + (int) (codUser  		^ (codUser  	>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OrdnapInfo))
			return false;
		
		
		OrdnapInfo obj = (OrdnapInfo) o;		
		return (codOwner    == obj.codOwner    && 
				codOrder 	== obj.codOrder    &&
				codSnapshot == obj.codSnapshot &&
				codUser     == obj.codUser		);
	}
}
