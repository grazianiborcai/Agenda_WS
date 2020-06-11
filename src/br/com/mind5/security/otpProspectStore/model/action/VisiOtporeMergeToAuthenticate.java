package br.com.mind5.security.otpProspectStore.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.info.UpswdMerger;

final class VisiOtporeMergeToAuthenticate extends ActionVisitorTemplateMergeV2<OtporeInfo, OtporeInfo> {
	
	public VisiOtporeMergeToAuthenticate(DeciTreeOption<OtporeInfo> option) {
		super(option, OtporeInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<OtporeInfo>> getActionClassHook() {
		return StdUpswdDaoSelect.class;
	}
	
	
	
	@Override protected List<OtporeInfo> mergeHook(List<OtporeInfo> baseInfos, List<OtporeInfo> selectedInfos) {	
		return UpswdMerger.mergeToAuthenticate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
