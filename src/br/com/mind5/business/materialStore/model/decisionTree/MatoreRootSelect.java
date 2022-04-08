package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.MatoreVisiEnforceMax;
import br.com.mind5.business.materialStore.model.action.MatoreVisiEnforceMin;
import br.com.mind5.business.materialStore.model.action.MatoreVisiEnforceRange;
import br.com.mind5.business.materialStore.model.action.MatoreVisiMergeMatlis;
import br.com.mind5.business.materialStore.model.action.MatoreVisiMergeStolis;
import br.com.mind5.business.materialStore.model.action.MatoreVisiMergeToSelect;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckLangu;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckMat;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckOwner;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckRead;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatoreRootSelect extends DeciTreeTemplateRead<MatoreInfo> {
	
	public MatoreRootSelect(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoreInfo> buildCheckerHook(DeciTreeOption<MatoreInfo> option) {
		ModelCheckerOption checkerOption;
		List<ModelChecker<MatoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoreInfo> checker;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new MatoreCheckRead(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatoreCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatoreCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatoreCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatoreCheckMat(checkerOption);
		queue.add(checker);	

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStd<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStd<MatoreInfo> select = new ActionStdCommom<MatoreInfo>(option, MatoreVisiMergeToSelect.class);
		ActionLazy<MatoreInfo> enforceMin = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiEnforceMin.class);
		ActionLazy<MatoreInfo> enforceMax = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiEnforceMax.class);		
		ActionLazy<MatoreInfo> enforceRange = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiEnforceRange.class);	
		ActionLazy<MatoreInfo> mergeMatlis = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiMergeMatlis.class);		
		ActionLazy<MatoreInfo> mergeStolis = new ActionLazyCommom<MatoreInfo>(option, MatoreVisiMergeStolis.class);	
		
		select.addPostAction(enforceMin);
		enforceMin.addPostAction(enforceMax);
		enforceMax.addPostAction(enforceRange);
		enforceRange.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeStolis);
		
		actions.add(select);		
		return actions;
	}
}
