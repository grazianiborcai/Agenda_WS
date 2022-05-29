package br.com.mind5.security.otpUserPassword.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;
import br.com.mind5.security.otpUserPassword.info.OtperasMerger;

public final class OtperasVisiMergeToAuthenticate extends ActionVisitorTemplateMerge<OtperasInfo, OtperasInfo> {
	
	public OtperasVisiMergeToAuthenticate(DeciTreeOption<OtperasInfo> option) {
		super(option, OtperasInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<OtperasInfo>> getVisitorClassHook() {
		return OtperasVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<OtperasInfo> mergeHook(List<OtperasInfo> baseInfos, List<OtperasInfo> selectedInfos) {	
		return OtperasMerger.mergeToAuthenticate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
