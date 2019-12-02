package br.com.mind5.business.materialList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.action.LazyMatlisMergeMatCateg;
import br.com.mind5.business.materialList.model.action.LazyMatlisMergeMatGroup;
import br.com.mind5.business.materialList.model.action.LazyMatlisMergeMatType;
import br.com.mind5.business.materialList.model.action.LazyMatlisMergeMatUnit;
import br.com.mind5.business.materialList.model.action.LazyMatlisMergeMatext;
import br.com.mind5.business.materialList.model.action.StdMatlisMergeToSelect;
import br.com.mind5.business.materialList.model.checker.MatlisCheckLangu;
import br.com.mind5.business.materialList.model.checker.MatlisCheckOwner;
import br.com.mind5.business.materialList.model.checker.MatlisCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class MatlisMatSelect extends DeciTreeReadTemplate<MatlisInfo> {
	
	public MatlisMatSelect(DeciTreeOption<MatlisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatlisInfo> buildDecisionCheckerHook(DeciTreeOption<MatlisInfo> option) {
		List<ModelChecker<MatlisInfo>> queue = new ArrayList<>();		
		ModelChecker<MatlisInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatlisCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatlisCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatlisCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatlisInfo>> buildActionsOnPassedHook(DeciTreeOption<MatlisInfo> option) {
		List<ActionStd<MatlisInfo>> actions = new ArrayList<>();
		
		ActionStd<MatlisInfo> select = new StdMatlisMergeToSelect(option);
		ActionLazy<MatlisInfo> mergeMatType = new LazyMatlisMergeMatType(option.conn, option.schemaName);
		ActionLazy<MatlisInfo> mergeMatCateg = new LazyMatlisMergeMatCateg(option.conn, option.schemaName);
		ActionLazy<MatlisInfo> mergeMatGroup = new LazyMatlisMergeMatGroup(option.conn, option.schemaName);
		ActionLazy<MatlisInfo> mergeMatUnit = new LazyMatlisMergeMatUnit(option.conn, option.schemaName);
		ActionLazy<MatlisInfo> mergeMatext = new LazyMatlisMergeMatext(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatType);
		mergeMatType.addPostAction(mergeMatCateg);
		mergeMatCateg.addPostAction(mergeMatGroup);
		mergeMatGroup.addPostAction(mergeMatUnit);
		mergeMatUnit.addPostAction(mergeMatext);
		
		actions.add(select);
		return actions;
	}
}
