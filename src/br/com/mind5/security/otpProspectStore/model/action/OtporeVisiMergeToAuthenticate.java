package br.com.mind5.security.otpProspectStore.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;
import br.com.mind5.security.otpProspectStore.info.OtporeMerger;

public final class OtporeVisiMergeToAuthenticate extends ActionVisitorTemplateMerge<OtporeInfo, OtporeInfo> {
	
	public OtporeVisiMergeToAuthenticate(DeciTreeOption<OtporeInfo> option) {
		super(option, OtporeInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<OtporeInfo>> getVisitorClassHook() {
		return OtporeVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<OtporeInfo> mergeHook(List<OtporeInfo> baseInfos, List<OtporeInfo> selectedInfos) {	
		return OtporeMerger.mergeToAuthenticate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
