package br.com.gda.legacy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.helper.CountryText;
import br.com.gda.legacy.dao.helper.CountryTextHelper;
import br.com.gda.legacy.db.ConnectionBD;

public class CountryTextDAO extends ConnectionBD {

	public ArrayList<CountryText> selectCountryText(List<String> country,
			List<String> language, List<String> name) throws SQLException {

		ArrayList<CountryText> countryTextList = new ArrayList<CountryText>();
		Connection conn = null;
		PreparedStatement selectStmt = null;
		ResultSet resultSet = null;

		try {

			conn = getConnection();

			CountryTextHelper countryTextHelper = new CountryTextHelper();

			selectStmt = conn.prepareStatement(countryTextHelper.prepareSelect(
					country, language, name));

			resultSet = selectStmt.executeQuery();

			while (resultSet.next()) {

				countryTextList.add(countryTextHelper.assignResult(resultSet));
			}

			return countryTextList;

		} catch (SQLException e) {
			throw e;
		} finally {
			closeConnection(conn, selectStmt, resultSet);
		}
	}

}
