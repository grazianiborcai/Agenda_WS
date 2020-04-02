package br.com.mind5.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.LazyMatextEnforceDefaultOn;
import br.com.mind5.business.materialText.model.action.LazyMatextMergeToSelect;
import br.com.mind5.business.materialText.model.action.LazyMatextRootUpdate;
import br.com.mind5.business.materialText.model.action.StdMatextMergeMatextarch;
import br.com.mind5.business.materialText.model.action.StdMatextSuccess;
import br.com.mind5.business.materialText.model.checker.MatextCheckMatextarch;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeMatextDeleteL3 extends DeciTreeWriteTemplate<MatextInfo> {

	public NodeMatextDeleteL3(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextInfo> buildDecisionCheckerHook(DeciTreeOption<MatextInfo> option) {
		List<ModelChecker<MatextInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextInfo> checker;
		ModelCheckerOption checkerOption;
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new MatextCheckMatextarch(checkerOption);
		queue.add(checker);		

		return new ModelCheckerQueue<MatextInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStdV1<MatextInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatextInfo> mergeMatextarch = new StdMatextMergeMatextarch(option);
		ActionLazyV1<MatextInfo> mergeToSelect = new LazyMatextMergeToSelect(option.conn, option.schemaName);
		ActionLazyV1<MatextInfo> enforceDefaultOn = new LazyMatextEnforceDefaultOn(option.conn, option.schemaName); 
		ActionLazyV1<MatextInfo> update = new LazyMatextRootUpdate(option.conn, option.schemaName); 
		
		mergeMatextarch.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(enforceDefaultOn);
		enforceDefaultOn.addPostAction(update);
		
		actions.add(mergeMatextarch);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<MatextInfo>> buildActionsOnFailedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStdV1<MatextInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatextInfo> success = new StdMatextSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
