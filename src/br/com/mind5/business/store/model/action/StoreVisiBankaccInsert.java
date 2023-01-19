package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccCopier;
import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.model.decisionTree.BankaccRootInsert;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiBankaccInsert extends ActionVisitorTemplateAction<StoreInfo, BankaccInfo> {
	
	public StoreVisiBankaccInsert(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, BankaccInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BankaccInfo>> getTreeClassHook() {
		return BankaccRootInsert.class;
	}
	
	
	
	@Override protected List<BankaccInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return BankaccCopier.copyFromStore(recordInfos);
	}
	
	
	
	protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<BankaccInfo> results) {
		return StoreMerger.mergeWithBankacc(baseInfos, results);
	}
}
