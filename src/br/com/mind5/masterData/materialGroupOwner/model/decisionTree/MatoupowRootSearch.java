package br.com.mind5.masterData.materialGroupOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiMergeMatoupSearch;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiMergeOwnelis;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiRootSelect;
import br.com.mind5.masterData.materialGroupOwner.model.checker.MatoupowCheckLangu;
import br.com.mind5.masterData.materialGroupOwner.model.checker.MatoupowCheckOwner;
import br.com.mind5.masterData.materialGroupOwner.model.checker.MatoupowCheckSearch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatoupowRootSearch extends DeciTreeTemplateWrite<MatoupowInfo> {
	
	public MatoupowRootSearch(DeciTreeOption<MatoupowInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoupowInfo> buildCheckerHook(DeciTreeOption<MatoupowInfo> option) {
		List<ModelChecker<MatoupowInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoupowInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatoupowCheckSearch(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatoupowCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatoupowCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoupowInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoupowInfo> option) {
		List<ActionStd<MatoupowInfo>> actions = new ArrayList<>();
		
		ActionStd<MatoupowInfo> mergeOwnelis = new ActionStdCommom<MatoupowInfo>(option, MatoupowVisiMergeOwnelis.class);
		ActionLazy<MatoupowInfo> mergeMatoupSearch = new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiMergeMatoupSearch.class);
		ActionLazy<MatoupowInfo> select = new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiRootSelect.class);
		
		mergeOwnelis.addPostAction(mergeMatoupSearch);
		mergeMatoupSearch.addPostAction(select);
		
		actions.add(mergeOwnelis);
		return actions;
	}
}
