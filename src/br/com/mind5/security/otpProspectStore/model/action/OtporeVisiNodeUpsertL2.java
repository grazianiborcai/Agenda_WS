package br.com.mind5.security.otpProspectStore.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.model.decisionTree.OtporeNodeUpsertL2;

public final class OtporeVisiNodeUpsertL2 extends ActionVisitorTemplateAction<OtporeInfo, OtporeInfo> {

	public OtporeVisiNodeUpsertL2(DeciTreeOption<OtporeInfo> option) {
		super(option, OtporeInfo.class, OtporeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OtporeInfo>> getTreeClassHook() {
		return OtporeNodeUpsertL2.class;
	}
	
	
	
	@Override protected List<OtporeInfo> toBaseClassHook(List<OtporeInfo> baseInfos, List<OtporeInfo> results) {
		return results;
	}
}
