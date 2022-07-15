package br.com.mind5.payment.countryPartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartner.info.CounparInfo;
import br.com.mind5.payment.countryPartner.model.decisionTree.CounparRootSelect;

public final class CounparVisiRootSelect extends ActionVisitorTemplateAction<CounparInfo, CounparInfo> {

	public CounparVisiRootSelect(DeciTreeOption<CounparInfo> option) {
		super(option, CounparInfo.class, CounparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CounparInfo>> getTreeClassHook() {
		return CounparRootSelect.class;
	}
	
	
	
	@Override protected List<CounparInfo> toBaseClassHook(List<CounparInfo> baseInfos, List<CounparInfo> results) {
		return results;
	}
}
