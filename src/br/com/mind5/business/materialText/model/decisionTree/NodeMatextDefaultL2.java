package br.com.mind5.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.LazyMatextEnforceDefaultOff;
import br.com.mind5.business.materialText.model.action.LazyMatextEnforceLChanged;
import br.com.mind5.business.materialText.model.action.LazyMatextMergeToSelect;
import br.com.mind5.business.materialText.model.action.LazyMatextMergeUsername;
import br.com.mind5.business.materialText.model.action.LazyMatextDaoUpdate;
import br.com.mind5.business.materialText.model.action.StdMatextMergeMatextault;
import br.com.mind5.business.materialText.model.action.StdMatextSuccess;
import br.com.mind5.business.materialText.model.checker.MatextCheckMatextault;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatextDefaultL2 extends DeciTreeTemplateWriteV2<MatextInfo> {
	
	public NodeMatextDefaultL2(DeciTreeOption<MatextInfo> option) {
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
		checker = new MatextCheckMatextault(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStdV2<MatextInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatextInfo> mergeMatextault = new StdMatextMergeMatextault(option);
		ActionLazy<MatextInfo> mergeToSelect = new LazyMatextMergeToSelect(option.conn, option.schemaName);
		ActionLazy<MatextInfo> enforceLChanged = new LazyMatextEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<MatextInfo> enforceLChangedBy = new LazyMatextMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatextInfo> enforceDefaultOff = new LazyMatextEnforceDefaultOff(option.conn, option.schemaName);
		ActionLazy<MatextInfo> update = new LazyMatextDaoUpdate(option.conn, option.schemaName);
		ActionStdV2<MatextInfo> success = new StdMatextSuccess(option);	
		
		mergeMatextault.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceDefaultOff);
		enforceDefaultOff.addPostAction(update);
		
		actions.add(mergeMatextault);
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<MatextInfo>> buildActionsOnFailedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStdV2<MatextInfo>> actions = new ArrayList<>();

		ActionStdV2<MatextInfo> success = new StdMatextSuccess(option);		
		actions.add(success);
		
		return actions;
	}
}
