package br.com.mind5.security.otp.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.otp.info.OtpInfo;
import br.com.mind5.security.otp.model.checker.OtpCheckHashToMatch;

public final class OtpNodeMatch extends DeciTreeTemplateWrite<OtpInfo> {
	
	public OtpNodeMatch(DeciTreeOption<OtpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OtpInfo> buildCheckerHook(DeciTreeOption<OtpInfo> option) {
		List<ModelChecker<OtpInfo>> queue = new ArrayList<>();		
		ModelChecker<OtpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new OtpCheckHashToMatch(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OtpInfo>> buildActionsOnPassedHook(DeciTreeOption<OtpInfo> option) {
		List<ActionStd<OtpInfo>> actions = new ArrayList<>();
		
		ActionStd<OtpInfo> success = new ActionStdSuccessCommom<OtpInfo>(option);
		actions.add(success);
		
		return actions;
	}
}
