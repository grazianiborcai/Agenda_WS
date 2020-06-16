package br.com.mind5.security.otpUserPassword.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.info.OtperasMerger;

final class VisiOtperasMergeToAuthenticate extends ActionVisitorTemplateMergeV2<OtperasInfo, OtperasInfo> {
	
	public VisiOtperasMergeToAuthenticate(DeciTreeOption<OtperasInfo> option) {
		super(option, OtperasInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<OtperasInfo>> getActionClassHook() {
		return StdOtperasDaoSelect.class;
	}
	
	
	
	@Override protected List<OtperasInfo> mergeHook(List<OtperasInfo> baseInfos, List<OtperasInfo> selectedInfos) {	
		return OtperasMerger.mergeToAuthenticate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
