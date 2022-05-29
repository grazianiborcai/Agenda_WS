package br.com.mind5.security.otpUserPassword.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.model.decisionTree.OtperasNodeUpsertL2;

public final class OtperasVisiNodeUpsertL2 extends ActionVisitorTemplateAction<OtperasInfo, OtperasInfo> {

	public OtperasVisiNodeUpsertL2(DeciTreeOption<OtperasInfo> option) {
		super(option, OtperasInfo.class, OtperasInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OtperasInfo>> getTreeClassHook() {
		return OtperasNodeUpsertL2.class;
	}
	
	
	
	@Override protected List<OtperasInfo> toBaseClassHook(List<OtperasInfo> baseInfos, List<OtperasInfo> results) {
		return results;
	}
}
