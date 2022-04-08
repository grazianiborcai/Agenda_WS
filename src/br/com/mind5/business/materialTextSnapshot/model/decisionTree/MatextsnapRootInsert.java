package br.com.mind5.business.materialTextSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.business.materialTextSnapshot.model.action.MatextsnapVisiDaoInsert;
import br.com.mind5.business.materialTextSnapshot.model.action.MatextsnapVisiMergeMatext;
import br.com.mind5.business.materialTextSnapshot.model.checker.MatextsnapCheckMat;
import br.com.mind5.business.materialTextSnapshot.model.checker.MatextsnapCheckOwner;
import br.com.mind5.business.materialTextSnapshot.model.checker.MatextsnapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatextsnapRootInsert extends DeciTreeTemplateWrite<MatextsnapInfo> {
	
	public MatextsnapRootInsert(DeciTreeOption<MatextsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextsnapInfo> buildCheckerHook(DeciTreeOption<MatextsnapInfo> option) {		
		List<ModelChecker<MatextsnapInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextsnapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextsnapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextsnapCheckOwner(checkerOption);
		queue.add(checker);			
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextsnapCheckMat(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatextsnapInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextsnapInfo> option) {
		List<ActionStd<MatextsnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatextsnapInfo> mergeMatext = new ActionStdCommom<MatextsnapInfo>(option, MatextsnapVisiMergeMatext.class);	
		ActionLazy<MatextsnapInfo> insert = new ActionLazyCommom<MatextsnapInfo>(option, MatextsnapVisiDaoInsert.class);	
		
		mergeMatext.addPostAction(insert);
		
		actions.add(mergeMatext);
		return actions;
	}
}
