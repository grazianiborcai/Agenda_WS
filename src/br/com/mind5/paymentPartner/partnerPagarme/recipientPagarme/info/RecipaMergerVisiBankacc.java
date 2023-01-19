package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class RecipaMergerVisiBankacc extends InfoMergerVisitorTemplate<RecipaInfo, BankaccInfo> {

	@Override public boolean shouldMerge(RecipaInfo baseInfo, BankaccInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore);
	}
	
	
	
	@Override public List<RecipaInfo> merge(RecipaInfo baseInfo, BankaccInfo selectedInfo) {
		List<RecipaInfo> results = new ArrayList<>();		
		Map<String, String> bankAccount = new HashMap<>();
		
		bankAccount = addHolderName(bankAccount, selectedInfo);
		bankAccount = addBank(bankAccount, selectedInfo);
		bankAccount = addBranchNumber(bankAccount, selectedInfo);
		bankAccount = addBranchCheckDigit(bankAccount, selectedInfo);
		bankAccount = addAccountNumber(bankAccount, selectedInfo);
		bankAccount = addAccountCheckDigit(bankAccount, selectedInfo);
		bankAccount = addHolderType(bankAccount, selectedInfo);
		bankAccount = addHolderDocument(bankAccount, selectedInfo);
		bankAccount = addBankType(bankAccount, selectedInfo);
		
		baseInfo.bankAccountData = bankAccount;
		baseInfo.codBankAccount = selectedInfo.codBankAccount;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private Map<String, String> addHolderName(Map<String, String> bankAccountData, BankaccInfo selectedInfo) {
		if(selectedInfo.holderName != null)		
			bankAccountData.put("holder_name", selectedInfo.holderName);
		
		return bankAccountData;
	}
		
	
	private Map<String, String> addBank(Map<String, String> bankAccountData, BankaccInfo selectedInfo) {
		String bank = "000" + selectedInfo.codCompe;
		
		if(selectedInfo.codCompe != null)	
			bankAccountData.put("bank", bank.substring(bank.length() - 3));
		
		return bankAccountData;
	}
	
	
	private Map<String, String> addBranchNumber(Map<String, String> bankAccountData, BankaccInfo selectedInfo) {
		String branchNumber = "0000" + selectedInfo.branchNumber;
		
		if(selectedInfo.branchNumber != null)
			bankAccountData.put("branch_number", branchNumber.substring(branchNumber.length() - 4));
		
		return bankAccountData;
	}
	
	
	private Map<String, String> addBranchCheckDigit(Map<String, String> bankAccountData, BankaccInfo selectedInfo) {
		if(selectedInfo.branchCheckDigit != null)
			bankAccountData.put("branch_check_digit", selectedInfo.branchCheckDigit);
		
		return bankAccountData;
	}
		
	
	private Map<String, String> addAccountNumber(Map<String, String> bankAccountData, BankaccInfo selectedInfo) {
		if(selectedInfo.accountNumber != null)
			bankAccountData.put("account_number", selectedInfo.accountNumber);
		
		return bankAccountData;
	}
		
	
	private Map<String, String> addAccountCheckDigit(Map<String, String> bankAccountData, BankaccInfo selectedInfo) {
		if(selectedInfo.accountCheckDigit != null)
			bankAccountData.put("account_check_digit", selectedInfo.accountCheckDigit);
		
		return bankAccountData;
	}
	
	
	private Map<String, String> addHolderType(Map<String, String> bankAccountData, BankaccInfo selectedInfo) {
		String holderType = null;
		
		if (selectedInfo.codBankHolderType == 1)
			holderType = "individual";
		
		if (selectedInfo.codBankHolderType == 2)
			holderType = "company";
		
		if(holderType != null)
			bankAccountData.put("holder_type", holderType);
		
		return bankAccountData;
	}
	
	
	private Map<String, String> addHolderDocument(Map<String, String> bankAccountData, BankaccInfo selectedInfo) {
		if(selectedInfo.holderDocument != null)
			bankAccountData.put("holder_document", selectedInfo.holderDocument);
		
		return bankAccountData;
	}
	
	
	private Map<String, String> addBankType(Map<String, String> bankAccountData, BankaccInfo selectedInfo) {
		String bankType = null;
		
		if (selectedInfo.codBankAccountType == 1)
			bankType = "checking";
		
		if (selectedInfo.codBankAccountType == 2)
			bankType = "savings";
		
		if(bankType != null)
			bankAccountData.put("type", bankType);
		
		return bankAccountData;
	}
}
