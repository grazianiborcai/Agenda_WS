package br.com.mind5.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.action.PhoneVisiDaoDelete;
import br.com.mind5.business.phone.model.action.PhoneVisiDaoUpdate;
import br.com.mind5.business.phone.model.action.PhoneVisiEnforceLChanged;
import br.com.mind5.business.phone.model.action.PhoneVisiMergeToDelete;
import br.com.mind5.business.phone.model.action.PhoneVisiMergeUsername;
import br.com.mind5.business.phone.model.checker.PhoneCheckDelete;
import br.com.mind5.business.phone.model.checker.PhoneCheckExist;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PhoneRootDelete extends DeciTreeTemplateWrite<PhoneInfo> {
	
	public PhoneRootDelete(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhoneInfo> buildCheckerHook(DeciTreeOption<PhoneInfo> option) {	
		List<ModelChecker<PhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PhoneCheckDelete(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PhoneCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhoneInfo> mergeToDelete = new ActionStdCommom<PhoneInfo>(option, PhoneVisiMergeToDelete.class);	
		ActionLazy<PhoneInfo> enforceLChanged = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiEnforceLChanged.class);
		ActionLazy<PhoneInfo> mergeUsername = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiMergeUsername.class);
		ActionLazy<PhoneInfo> update = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiDaoUpdate.class);
		ActionLazy<PhoneInfo> delete = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiDaoDelete.class);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeUsername);
		mergeUsername.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToDelete);		
		
		return actions;
	}
}
