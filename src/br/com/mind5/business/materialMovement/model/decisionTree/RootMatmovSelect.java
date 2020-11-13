package br.com.mind5.business.materialMovement.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovMergeMatlis;
import br.com.mind5.business.materialMovement.model.action.StdMatmovMergeToSelect;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckLangu;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckMat;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckOwner;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckRead;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckStorauth;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class RootMatmovSelect extends DeciTreeTemplateRead<MatmovInfo> {
	
	public RootMatmovSelect(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatmovInfo> buildCheckerHook(DeciTreeOption<MatmovInfo> option) {
		List<ModelChecker<MatmovInfo>> queue = new ArrayList<>();		
		ModelChecker<MatmovInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new MatmovCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatmovCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatmovCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatmovCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatmovCheckMat(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatmovCheckStorauth(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatmovInfo>> buildActionsOnPassedHook(DeciTreeOption<MatmovInfo> option) {
		List<ActionStd<MatmovInfo>> actions = new ArrayList<>();

		ActionStd<MatmovInfo> select = new StdMatmovMergeToSelect(option);
		ActionLazy<MatmovInfo> mergeMatlis = new LazyMatmovMergeMatlis(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatlis);
		
		actions.add(select);
		return actions;
	}
}
