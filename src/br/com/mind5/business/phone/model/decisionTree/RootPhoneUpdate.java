package br.com.mind5.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.action.LazyPhoneEnforceLChanged;
import br.com.mind5.business.phone.model.action.LazyPhoneMergeCountrone;
import br.com.mind5.business.phone.model.action.LazyPhoneMergeFormone;
import br.com.mind5.business.phone.model.action.LazyPhoneMergeUsername;
import br.com.mind5.business.phone.model.action.LazyPhoneNodeDefaultL1;
import br.com.mind5.business.phone.model.action.LazyPhoneNodeSnapshot;
import br.com.mind5.business.phone.model.action.LazyPhoneNodeUpdate;
import br.com.mind5.business.phone.model.action.StdPhoneMergeToUpdate;
import br.com.mind5.business.phone.model.checker.PhoneCheckCountrone;
import br.com.mind5.business.phone.model.checker.PhoneCheckExist;
import br.com.mind5.business.phone.model.checker.PhoneCheckLangu;
import br.com.mind5.business.phone.model.checker.PhoneCheckLength;
import br.com.mind5.business.phone.model.checker.PhoneCheckOwner;
import br.com.mind5.business.phone.model.checker.PhoneCheckRefMulti;
import br.com.mind5.business.phone.model.checker.PhoneCheckRefWrite;
import br.com.mind5.business.phone.model.checker.PhoneCheckUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootPhoneUpdate extends DeciTreeTemplateWrite<PhoneInfo> {
	
	public RootPhoneUpdate(DeciTreeOption<PhoneInfo> option) {
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
		checker = new PhoneCheckUpdate(checkerOption);
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
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PhoneCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStd<PhoneInfo>> actions = new ArrayList<>();		
		
		ActionStd<PhoneInfo> mergeToUpdate = new StdPhoneMergeToUpdate(option);	
		ActionLazy<PhoneInfo> mergeCountrone = new LazyPhoneMergeCountrone(option.conn, option.schemaName);	
		ActionLazy<PhoneInfo> mergeFormone = new LazyPhoneMergeFormone(option.conn, option.schemaName);	
		ActionLazy<PhoneInfo> mergeUsername = new LazyPhoneMergeUsername(option.conn, option.schemaName);	
		ActionLazy<PhoneInfo> enforceLChanged = new LazyPhoneEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<PhoneInfo> nodeUpdate = new LazyPhoneNodeUpdate(option.conn, option.schemaName);	
		ActionLazy<PhoneInfo> nodeDefault = new LazyPhoneNodeDefaultL1(option.conn, option.schemaName);
		ActionLazy<PhoneInfo> nodeSnapshot = new LazyPhoneNodeSnapshot(option.conn, option.schemaName);	
		
		mergeToUpdate.addPostAction(mergeCountrone);
		mergeCountrone.addPostAction(mergeFormone);
		mergeFormone.addPostAction(mergeUsername);		
		mergeUsername.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(nodeUpdate);
		nodeUpdate.addPostAction(nodeDefault);
		nodeDefault.addPostAction(nodeSnapshot);
		
		actions.add(mergeToUpdate);		
		return actions;
	}
}
