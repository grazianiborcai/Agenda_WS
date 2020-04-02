package br.com.mind5.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.action.LazyPhoneDelete;
import br.com.mind5.business.phone.model.action.LazyPhoneEnforceLChanged;
import br.com.mind5.business.phone.model.action.LazyPhoneMergeUsername;
import br.com.mind5.business.phone.model.action.LazyPhoneUpdate;
import br.com.mind5.business.phone.model.action.StdPhoneMergeToDelete;
import br.com.mind5.business.phone.model.checker.PhoneCheckDelete;
import br.com.mind5.business.phone.model.checker.PhoneCheckExist;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootPhoneDelete extends DeciTreeWriteTemplate<PhoneInfo> {
	
	public RootPhoneDelete(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhoneInfo> buildDecisionCheckerHook(DeciTreeOption<PhoneInfo> option) {	
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStdV1<PhoneInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<PhoneInfo> mergeToDelete = new StdPhoneMergeToDelete(option);	
		ActionLazyV1<PhoneInfo> enforceLChanged = new LazyPhoneEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<PhoneInfo> mergeUsername = new LazyPhoneMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<PhoneInfo> update = new LazyPhoneUpdate(option.conn, option.schemaName);
		ActionLazyV1<PhoneInfo> delete = new LazyPhoneDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeUsername);
		mergeUsername.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToDelete);		
		
		return actions;
	}
}
