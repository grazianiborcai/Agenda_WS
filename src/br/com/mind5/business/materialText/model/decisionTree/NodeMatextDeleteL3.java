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
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatextDeleteL3 extends DeciTreeTemplateWriteV2<MatextInfo> {

	public NodeMatextDeleteL3(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatextInfo> buildCheckerHook(DeciTreeOption<MatextInfo> option) {
		List<ModelCheckerV1<MatextInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatextInfo> checker;
		ModelCheckerOption checkerOption;
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new MatextCheckMatextarch(checkerOption);
		queue.add(checker);		

		return new ModelCheckerHelperQueueV2<MatextInfo>(queue);
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
