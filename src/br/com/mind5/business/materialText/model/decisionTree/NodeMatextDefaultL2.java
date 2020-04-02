package br.com.mind5.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.LazyMatextEnforceDefaultOff;
import br.com.mind5.business.materialText.model.action.LazyMatextEnforceLChanged;
import br.com.mind5.business.materialText.model.action.LazyMatextMergeToSelect;
import br.com.mind5.business.materialText.model.action.LazyMatextMergeUsername;
import br.com.mind5.business.materialText.model.action.LazyMatextUpdate;
import br.com.mind5.business.materialText.model.action.StdMatextMergeMatextault;
import br.com.mind5.business.materialText.model.action.StdMatextSuccess;
import br.com.mind5.business.materialText.model.checker.MatextCheckMatextault;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeMatextDefaultL2 extends DeciTreeWriteTemplate<MatextInfo> {
	
	public NodeMatextDefaultL2(DeciTreeOption<MatextInfo> option) {
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
		checker = new MatextCheckMatextault(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStdV1<MatextInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatextInfo> mergeMatextault = new StdMatextMergeMatextault(option);
		ActionLazyV1<MatextInfo> mergeToSelect = new LazyMatextMergeToSelect(option.conn, option.schemaName);
		ActionLazyV1<MatextInfo> enforceLChanged = new LazyMatextEnforceLChanged(option.conn, option.schemaName);	
		ActionLazyV1<MatextInfo> enforceLChangedBy = new LazyMatextMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<MatextInfo> enforceDefaultOff = new LazyMatextEnforceDefaultOff(option.conn, option.schemaName);
		ActionLazyV1<MatextInfo> update = new LazyMatextUpdate(option.conn, option.schemaName);
		ActionStdV1<MatextInfo> success = new StdMatextSuccess(option);	
		
		mergeMatextault.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceDefaultOff);
		enforceDefaultOff.addPostAction(update);
		
		actions.add(mergeMatextault);
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<MatextInfo>> buildActionsOnFailedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStdV1<MatextInfo>> actions = new ArrayList<>();

		ActionStdV1<MatextInfo> success = new StdMatextSuccess(option);		
		actions.add(success);
		
		return actions;
	}
}
