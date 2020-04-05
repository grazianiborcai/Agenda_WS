package br.com.mind5.business.phone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.action.LazyPhoneUpdate;
import br.com.mind5.business.phone.model.action.StdPhoneInsertPhonap;
import br.com.mind5.business.phone.model.checker.PhoneCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodePhoneSnapshot extends DeciTreeWriteTemplate<PhoneInfo> {
	
	public NodePhoneSnapshot(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PhoneInfo> buildCheckerHook(DeciTreeOption<PhoneInfo> option) {
		List<ModelChecker<PhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<PhoneInfo> checker;	

		checker = new PhoneCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<PhoneInfo> option) {
		List<ActionStdV1<PhoneInfo>> actions = new ArrayList<>();

		ActionStdV1<PhoneInfo> insertPhonap = new StdPhoneInsertPhonap(option);
		ActionLazyV1<PhoneInfo> update = new LazyPhoneUpdate(option.conn, option.schemaName);
		
		insertPhonap.addPostAction(update);

		actions.add(insertPhonap);		
		return actions;
	}
}
