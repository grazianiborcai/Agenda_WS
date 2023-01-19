package br.com.mind5.business.bankAccountSnapshot.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class BankaccnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codBankAccount;
	public long codSnapshot;
	public long codStore;
	public long codBank;
	public String codCountry;
	public String txtCountry;
	public String txtBank;
	public String codCompe;
	public int codBankAccountType;
	public String txtBankAccountType;
	public int codBankHolderType;
	public String txtBankHolderType;
	public String branchNumber;
	public String branchCheckDigit;
	public String accountNumber;
	public String accountCheckDigit;
	public String holderName;
	public String holderDocument;
	public String codPayBankAccount;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	public String username;

	
	
	public BankaccnapInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codBankAccount = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codBank = DefaultValue.number();
		codStore = DefaultValue.number();
		codBankAccountType = DefaultValue.number();
		codBankHolderType = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static BankaccnapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, BankaccnapInfo.class);
	}
	
	
	
	public static List<BankaccnapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, BankaccnapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  		^ (codOwner			>>> 32));
		result = result * 31 + (int) (codSnapshot  		^ (codSnapshot		>>> 32));
		result = result * 31 + (int) (codBankAccount 	^ (codBankAccount 	>>> 32));
		result = result * 31 + (int) (codBank 			^ (codBank 			>>> 32));
		
		if (branchNumber != null)
			result = result * 31 + branchNumber.hashCode();
		
		if (accountNumber != null)
			result = result * 31 + accountNumber.hashCode();
		
		if (codLanguage != null)
			result = result * 31 + codLanguage.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof BankaccnapInfo))
			return false;
		
		
		BankaccnapInfo obj = (BankaccnapInfo) o;		
		return (codOwner 		== obj.codOwner 		&&
				codSnapshot 	== obj.codSnapshot 		&&
				codBankAccount  == obj.codBankAccount	&&
				codBank  		== obj.codBank			&&
				super.isStringEqual(branchNumber , obj.branchNumber)	&&
				super.isStringEqual(accountNumber, obj.accountNumber)	&&
				super.isStringEqual(codLanguage  , obj.codLanguage));
	}
}
