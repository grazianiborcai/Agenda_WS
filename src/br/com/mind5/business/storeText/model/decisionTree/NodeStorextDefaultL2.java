package br.com.mind5.business.storeText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.action.LazyStorextDaoUpdate;
import br.com.mind5.business.storeText.model.action.LazyStorextEnforceDefaultOff;
import br.com.mind5.business.storeText.model.action.LazyStorextEnforceLChanged;
import br.com.mind5.business.storeText.model.action.LazyStorextMergeToSelect;
import br.com.mind5.business.storeText.model.action.LazyStorextMergeUsername;
import br.com.mind5.business.storeText.model.action.StdStorextMergeStorextault;
import br.com.mind5.business.storeText.model.action.StdStorextSuccess;
import br.com.mind5.business.storeText.model.checker.StorextCheckStorextault;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeStorextDefaultL2 extends DeciTreeTemplateWrite<StorextInfo> {
	
	public NodeStorextDefaultL2(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorextInfo> buildCheckerHook(DeciTreeOption<StorextInfo> option) {
		List<ModelChecker<StorextInfo>> queue = new ArrayList<>();		
		ModelChecker<StorextInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StorextCheckStorextault(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorextInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStd<StorextInfo>> actions = new ArrayList<>();
		
		ActionStd<StorextInfo> mergeStorextault = new StdStorextMergeStorextault(option);
		ActionLazy<StorextInfo> mergeToSelect = new LazyStorextMergeToSelect(option.conn, option.schemaName);
		ActionLazy<StorextInfo> enforceLChanged = new LazyStorextEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<StorextInfo> enforceLChangedBy = new LazyStorextMergeUsername(option.conn, option.schemaName);
		ActionLazy<StorextInfo> enforceDefaultOff = new LazyStorextEnforceDefaultOff(option.conn, option.schemaName);
		ActionLazy<StorextInfo> update = new LazyStorextDaoUpdate(option.conn, option.schemaName);
		ActionStd<StorextInfo> success = new StdStorextSuccess(option);	
		
		mergeStorextault.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceDefaultOff);
		enforceDefaultOff.addPostAction(update);
		
		actions.add(mergeStorextault);
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StorextInfo>> buildActionsOnFailedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStd<StorextInfo>> actions = new ArrayList<>();

		ActionStd<StorextInfo> success = new StdStorextSuccess(option);		
		actions.add(success);
		
		return actions;
	}
}
