package br.com.gda.business.materialSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.business.materialSnapshot.model.action.LazyMatsnapMergeMatCateg;
import br.com.gda.business.materialSnapshot.model.action.LazyMatsnapMergeMatGroup;
import br.com.gda.business.materialSnapshot.model.action.LazyMatsnapMergeMatType;
import br.com.gda.business.materialSnapshot.model.action.LazyMatsnapMergeMatUnit;
import br.com.gda.business.materialSnapshot.model.action.LazyMatsnapMergeMatextsnap;
import br.com.gda.business.materialSnapshot.model.action.StdMatsnapSelect;
import br.com.gda.business.materialSnapshot.model.checker.MatsnapCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootMatsnapSelect extends DeciTreeReadTemplate<MatsnapInfo> {
	
	public RootMatsnapSelect(DeciTreeOption<MatsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatsnapInfo> buildDecisionCheckerHook(DeciTreeOption<MatsnapInfo> option) {
		List<ModelChecker<MatsnapInfo>> queue = new ArrayList<>();		
		ModelChecker<MatsnapInfo> checker;
		
		checker = new MatsnapCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatsnapInfo>> buildActionsOnPassedHook(DeciTreeOption<MatsnapInfo> option) {
		List<ActionStd<MatsnapInfo>> actions = new ArrayList<>();
		
		ActionStd<MatsnapInfo> select = new StdMatsnapSelect(option);
		ActionLazy<MatsnapInfo> mergeMatextsnap = new LazyMatsnapMergeMatextsnap(option.conn, option.schemaName);
		ActionLazy<MatsnapInfo> mergeMatType = new LazyMatsnapMergeMatType(option.conn, option.schemaName);
		ActionLazy<MatsnapInfo> mergeMatCateg = new LazyMatsnapMergeMatCateg(option.conn, option.schemaName);
		ActionLazy<MatsnapInfo> mergeMatGroup = new LazyMatsnapMergeMatGroup(option.conn, option.schemaName);
		ActionLazy<MatsnapInfo> mergeMatUnit = new LazyMatsnapMergeMatUnit(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatextsnap);
		mergeMatextsnap.addPostAction(mergeMatType);
		mergeMatType.addPostAction(mergeMatCateg);
		mergeMatCateg.addPostAction(mergeMatGroup);
		mergeMatGroup.addPostAction(mergeMatUnit);
		
		actions.add(select);
		return actions;
	}
}
