package br.com.mind5.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.LazyMatextNodeDeleteL1;
import br.com.mind5.business.materialText.model.action.LazyMatextNodeDeleteL2;
import br.com.mind5.business.materialText.model.action.StdMatextMergeToDelete;
import br.com.mind5.business.materialText.model.checker.MatextCheckDelete;
import br.com.mind5.business.materialText.model.checker.MatextCheckExist;
import br.com.mind5.business.materialText.model.checker.MatextCheckLangu;
import br.com.mind5.business.materialText.model.checker.MatextCheckMat;
import br.com.mind5.business.materialText.model.checker.MatextCheckOwner;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootMatextDelete extends DeciTreeWriteTemplate<MatextInfo> {
	
	public RootMatextDelete(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextInfo> buildDecisionCheckerHook(DeciTreeOption<MatextInfo> option) {
		List<ModelChecker<MatextInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new MatextCheckDelete(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatextCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatextCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatextCheckMat(checkerOption);
		queue.add(checker);	
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatextCheckExist(checkerOption);
		queue.add(checker);		

		return new ModelCheckerQueue<MatextInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStdV1<MatextInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatextInfo> mergeToDelete = new StdMatextMergeToDelete(option);
		ActionLazyV1<MatextInfo> nodeL1 = new LazyMatextNodeDeleteL1(option.conn, option.schemaName);
		ActionLazyV1<MatextInfo> nodeL2 = new LazyMatextNodeDeleteL2(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(nodeL1);
		mergeToDelete.addPostAction(nodeL2);		
		
		actions.add(mergeToDelete);
		return actions;
	}
}
