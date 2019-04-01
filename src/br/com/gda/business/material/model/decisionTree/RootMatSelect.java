package br.com.gda.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.action.LazyMatMergeMatCateg;
import br.com.gda.business.material.model.action.LazyMatMergeMatGroup;
import br.com.gda.business.material.model.action.LazyMatMergeMatType;
import br.com.gda.business.material.model.action.LazyMatMergeMatUnit;
import br.com.gda.business.material.model.action.LazyMatMergeMatext;
import br.com.gda.business.material.model.action.StdMatSelect;
import br.com.gda.business.material.model.checker.MatCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootMatSelect extends DeciTreeReadTemplate<MatInfo> {
	
	public RootMatSelect(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatInfo> buildDecisionCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelChecker<MatInfo>> queue = new ArrayList<>();		
		ModelChecker<MatInfo> checker;
		
		checker = new MatCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStd<MatInfo>> actions = new ArrayList<>();
		
		ActionStd<MatInfo> select = new StdMatSelect(option);
		ActionLazy<MatInfo> mergeMatType = new LazyMatMergeMatType(option.conn, option.schemaName);
		ActionLazy<MatInfo> mergeMatCateg = new LazyMatMergeMatCateg(option.conn, option.schemaName);
		ActionLazy<MatInfo> mergeMatGroup = new LazyMatMergeMatGroup(option.conn, option.schemaName);
		ActionLazy<MatInfo> mergeMatUnit = new LazyMatMergeMatUnit(option.conn, option.schemaName);
		ActionLazy<MatInfo> mergeMatext = new LazyMatMergeMatext(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatType);
		mergeMatType.addPostAction(mergeMatCateg);
		mergeMatCateg.addPostAction(mergeMatGroup);
		mergeMatGroup.addPostAction(mergeMatUnit);
		mergeMatUnit.addPostAction(mergeMatext);
		
		actions.add(select);
		return actions;
	}
}
