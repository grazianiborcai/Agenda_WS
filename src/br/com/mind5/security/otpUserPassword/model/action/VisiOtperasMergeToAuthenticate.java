package br.com.mind5.security.otpUserPassword.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.info.OtperasMerger;

final class VisiOtperasMergeToAuthenticate extends ActionVisitorTemplateMerge<OtperasInfo, OtperasInfo> {
	
	public VisiOtperasMergeToAuthenticate(DeciTreeOption<OtperasInfo> option) {
		super(option, OtperasInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OtperasInfo>> getActionClassHook() {
		return StdOtperasDaoSelect.class;
	}
	
	
	
	@Override protected List<OtperasInfo> mergeHook(List<OtperasInfo> baseInfos, List<OtperasInfo> selectedInfos) {	
		return OtperasMerger.mergeToAuthenticate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
