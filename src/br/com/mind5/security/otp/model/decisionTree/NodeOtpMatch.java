package br.com.mind5.security.otp.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.otp.info.OtpInfo;
import br.com.mind5.security.otp.model.action.StdOtpSuccess;
import br.com.mind5.security.otp.model.checker.OtpCheckHashToMatch;

public final class NodeOtpMatch extends DeciTreeTemplateWriteV2<OtpInfo> {
	
	public NodeOtpMatch(DeciTreeOption<OtpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OtpInfo> buildCheckerHook(DeciTreeOption<OtpInfo> option) {
		List<ModelCheckerV1<OtpInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OtpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new OtpCheckHashToMatch(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<OtpInfo>> buildActionsOnPassedHook(DeciTreeOption<OtpInfo> option) {
		List<ActionStdV2<OtpInfo>> actions = new ArrayList<>();
		
		ActionStdV2<OtpInfo> success = new StdOtpSuccess(option);
		actions.add(success);
		
		return actions;
	}
}
