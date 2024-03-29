package br.com.mind5.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.action.PhoneVisiEnforceCreatedBy;
import br.com.mind5.business.phone.model.action.PhoneVisiEnforceCreatedOn;
import br.com.mind5.business.phone.model.action.PhoneVisiEnforceLChanged;
import br.com.mind5.business.phone.model.action.PhoneVisiMergeCountrone;
import br.com.mind5.business.phone.model.action.PhoneVisiMergeFormone;
import br.com.mind5.business.phone.model.action.PhoneVisiMergeUsername;
import br.com.mind5.business.phone.model.action.PhoneVisiNodeDefaultL1;
import br.com.mind5.business.phone.model.action.PhoneVisiNodeInsert;
import br.com.mind5.business.phone.model.action.PhoneVisiNodeSnapshot;
import br.com.mind5.business.phone.model.checker.PhoneCheckCountrone;
import br.com.mind5.business.phone.model.checker.PhoneCheckInsert;
import br.com.mind5.business.phone.model.checker.PhoneCheckLangu;
import br.com.mind5.business.phone.model.checker.PhoneCheckLength;
import br.com.mind5.business.phone.model.checker.PhoneCheckLimit;
import br.com.mind5.business.phone.model.checker.PhoneCheckOwner;
import br.com.mind5.business.phone.model.checker.PhoneCheckRefMulti;
import br.com.mind5.business.phone.model.checker.PhoneCheckRefWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PhoneRootInsert extends DeciTreeTemplateWrite<PhoneInfo> {
	
	public PhoneRootInsert(DeciTreeOption<PhoneInfo> option) {
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
		checker = new PhoneCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PhoneCheckLength(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new PhoneCheckRefWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new PhoneCheckRefMulti(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PhoneCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PhoneCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PhoneCheckCountrone(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new PhoneCheckLimit(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();	
		
		ActionStd <PhoneInfo> nodeSafe         = new PhoneNodeSafe(option).toAction();
		ActionStd <PhoneInfo> mergeCountrone   = new ActionStdCommom <PhoneInfo>(option, PhoneVisiMergeCountrone.class);	
		ActionLazy<PhoneInfo> mergeFormone     = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiMergeFormone.class);	
		ActionLazy<PhoneInfo> mergeUsername    = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiMergeUsername.class);
		ActionLazy<PhoneInfo> enforceLChanged  = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiEnforceLChanged.class);
		ActionLazy<PhoneInfo> enforceCreatedOn = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiEnforceCreatedOn.class);	
		ActionLazy<PhoneInfo> enforceCreatedBy = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiEnforceCreatedBy.class);	
		ActionLazy<PhoneInfo> nodeInsert       = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiNodeInsert.class);	
		ActionLazy<PhoneInfo> nodeDefault      = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiNodeDefaultL1.class);
		ActionLazy<PhoneInfo> nodeSnapshot     = new ActionLazyCommom<PhoneInfo>(option, PhoneVisiNodeSnapshot.class);
		
		mergeCountrone.addPostAction(mergeFormone);
		mergeFormone.addPostAction(mergeUsername);		
		mergeUsername.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);		
		enforceCreatedBy.addPostAction(nodeInsert);
		nodeInsert.addPostAction(nodeDefault);
		nodeDefault.addPostAction(nodeSnapshot);
		
		actions.add(nodeSafe);
		actions.add(mergeCountrone);
		
		return actions;
	}
}
