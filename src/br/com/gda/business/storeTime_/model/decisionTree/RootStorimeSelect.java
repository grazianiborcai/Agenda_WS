package br.com.gda.business.storeTime_.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeTime_.info.StorimeInfo;
import br.com.gda.business.storeTime_.model.action.LazyStorimeNodeSelect;
import br.com.gda.business.storeTime_.model.action.StdStorimeMergeStowotm;
import br.com.gda.business.storeTime_.model.checker.StorimeCheckReadWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;


public final class RootStorimeSelect extends DeciTreeReadTemplate<StorimeInfo> {
	
	public RootStorimeSelect(DeciTreeOption<StorimeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorimeInfo> buildDecisionCheckerHook(DeciTreeOption<StorimeInfo> option) {
		List<ModelChecker<StorimeInfo>> queue = new ArrayList<>();		
		ModelChecker<StorimeInfo> checker;
		
		checker = new StorimeCheckReadWrite();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorimeInfo>> buildActionsOnPassedHook(DeciTreeOption<StorimeInfo> option) {
		List<ActionStd<StorimeInfo>> actions = new ArrayList<>();

		ActionStd<StorimeInfo> mergeStowotm = new StdStorimeMergeStowotm(option);
		ActionLazy<StorimeInfo> nodeSelect = new LazyStorimeNodeSelect(option.conn, option.schemaName);
		
		mergeStowotm.addPostAction(nodeSelect);
		
		actions.add(mergeStowotm);
		return actions;
	}
}
