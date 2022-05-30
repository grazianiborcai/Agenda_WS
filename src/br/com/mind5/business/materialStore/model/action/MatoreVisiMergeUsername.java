package br.com.mind5.business.materialStore.model.action;

import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.info.MatoreMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.UsernameRootSelect;

public final class MatoreVisiMergeUsername extends ActionVisitorTemplateMerge<MatoreInfo, UsernameInfo> {
	
	public MatoreVisiMergeUsername(DeciTreeOption<MatoreInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return UsernameRootSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<MatoreInfo> baseInfos) {
		return UsernameCopier.copyFromMatore(baseInfos);	
	}
	
	
	
	@Override protected List<MatoreInfo> mergeHook(List<MatoreInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return MatoreMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
