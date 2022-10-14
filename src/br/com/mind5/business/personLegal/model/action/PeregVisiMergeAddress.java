package br.com.mind5.business.personLegal.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.AddressRootSearchPereg;
import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.info.PeregMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiMergeAddress extends ActionVisitorTemplateMerge<PeregInfo, AddressInfo> {
	
	public PeregVisiMergeAddress(DeciTreeOption<PeregInfo> option) {
		super(option, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return AddressRootSearchPereg.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<PeregInfo> baseInfos) {
		return AddressInfo.copyFrom(baseInfos);	
	}
	
	
	
	@Override protected List<PeregInfo> mergeHook(List<PeregInfo> baseInfos, List<AddressInfo> selectedInfos) {	
		return PeregMerger.mergeWithAddress(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
