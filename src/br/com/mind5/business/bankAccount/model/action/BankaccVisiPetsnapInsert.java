package br.com.mind5.business.bankAccount.model.action;

import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.info.BankaccMerger;
import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.business.petSnapshot.model.decisionTree.PetsnapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccVisiPetsnapInsert extends ActionVisitorTemplateAction<BankaccInfo, PetsnapInfo> {

	public BankaccVisiPetsnapInsert(DeciTreeOption<BankaccInfo> option) {
		super(option, BankaccInfo.class, PetsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetsnapInfo>> getTreeClassHook() {
		return PetsnapRootInsert.class;
	}
	
	
	
	protected List<BankaccInfo> toBaseClassHook(List<BankaccInfo> baseInfos, List<PetsnapInfo> selectedInfos) {
		return BankaccMerger.mergeWithPetsnap(baseInfos, selectedInfos);
	}
}
