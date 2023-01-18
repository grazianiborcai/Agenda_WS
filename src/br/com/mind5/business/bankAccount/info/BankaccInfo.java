package br.com.mind5.business.bankAccount.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class BankaccInfo extends InfoRecord implements Cloneable {
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
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	public String username;

	
	
	public BankaccInfo() {
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
	
	
	
	public static BankaccInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, BankaccInfo.class);
	}
	
	
	
	public static List<BankaccInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, BankaccInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  		^ (codOwner			>>> 32));
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
		
		
		if (!(o instanceof BankaccInfo))
			return false;
		
		
		BankaccInfo obj = (BankaccInfo) o;		
		return (codOwner 		== obj.codOwner 		&& 
				codBankAccount  == obj.codBankAccount	&&
				codBank  		== obj.codBank			&&
				super.isStringEqual(branchNumber , obj.branchNumber)	&&
				super.isStringEqual(accountNumber, obj.accountNumber)	&&
				super.isStringEqual(codLanguage  , obj.codLanguage));
	}
}
