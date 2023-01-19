package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.checker;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.model.checker.BankaccCheckExistStore;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaInfo;

public final class RecipaCheckBankacc extends ModelCheckerTemplateForward<RecipaInfo, BankaccInfo> {
	
	public RecipaCheckBankacc(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<BankaccInfo> getCheckerHook(ModelCheckerOption option) {
		return new BankaccCheckExistStore(option);
	}
	
	
	
	@Override protected BankaccInfo toForwardClass(RecipaInfo baseRecord) {
		return BankaccInfo.copyFrom(baseRecord);
	}
}
