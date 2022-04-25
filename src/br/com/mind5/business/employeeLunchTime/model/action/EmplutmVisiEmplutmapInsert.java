package br.com.mind5.business.employeeLunchTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.info.EmplutmMerger;
import br.com.mind5.business.employeeLunchTimeSnapshot.info.EmplutmapInfo;
import br.com.mind5.business.employeeLunchTimeSnapshot.model.decisionTree.EmplutmapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmVisiEmplutmapInsert extends ActionVisitorTemplateAction<EmplutmInfo, EmplutmapInfo> {

	public EmplutmVisiEmplutmapInsert(DeciTreeOption<EmplutmInfo> option) {
		super(option, EmplutmInfo.class, EmplutmapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplutmapInfo>> getTreeClassHook() {
		return EmplutmapRootInsert.class;
	}
	
	
	
	protected List<EmplutmInfo> toBaseClassHook(List<EmplutmInfo> baseInfos, List<EmplutmapInfo> selectedInfos) {
		return EmplutmMerger.mergeWithEmplutmap(baseInfos, selectedInfos);
	}
}
