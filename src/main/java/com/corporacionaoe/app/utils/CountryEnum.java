package com.corporacionaoe.app.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CountryEnum {
    WESTERN_SAHARA("eh","Western Sahara"),
    SUDAN("sd","Sudan"),
    GUINEA("gn","Guinea"),
    JAPAN("jp","Japan"),
    LESOTHO("ls","Lesotho"),
    VANUATU("vu","Vanuatu"),
    URUGUAY("uy","Uruguay"),
    VIRGIN_ISLANDS_BRITISH("vg","Virgin Islands (British)"),
    CENTRAL_AFRICAN_REPUBLIC("cf","Central African Republic"),
    FINLAND("fi","Finland"),
    GIBRALTAR("gi","Gibraltar"),
    BRITISH_INDIAN_OCEAN_TERRITORY("io","British Indian Ocean Territory"),
    SURINAME("sr","Suriname"),
    BRAZIL("br","Brazil"),
    BURKINA_FASO("bf","Burkina Faso"),
    MALAWI("mw","Malawi"),
    CURAÇAO("cw","Curaçao"),
    LIBERIA("lr","Liberia"),
    FRENCH_POLYNESIA("pf","French Polynesia"),
    ANTARCTICA("aq","Antarctica"),
    SOMALIA("so","Somalia"),
    CAMEROON("cm","Cameroon"),
    MARSHALL_ISLANDS("mh","Marshall Islands"),
    SLOVENIA("si","Slovenia"),
    COMOROS("km","Comoros"),
    BOSNIA_AND_HERZEGOVINA("ba","Bosnia and Herzegovina"),
    GREECE("gr","Greece"),
    MALTA("mt","Malta"),
    ICELAND("is","Iceland"),
    CROATIA("hr","Croatia"),
    NIUE("nu","Niue"),
    TIMOR_LESTE("tl","Timor-Leste"),
    CZECHIA("cz","Czechia"),
    TAJIKISTAN("tj","Tajikistan"),
    BELARUS("by","Belarus"),
    UNITED_KINGDOM_OF_GREAT_BRITAIN_AND_NORTHERN_IRELAND("gb","United Kingdom of Great Britain and Northern Ireland"),
    NORWAY("no","Norway"),
    INDONESIA("id","Indonesia"),
    GABON("ga","Gabon"),
    JERSEY("je","Jersey"),
    FAROE_ISLANDS("fo","Faroe Islands"),
    SLOVAKIA("sk","Slovakia"),
    SAMOA("ws","Samoa"),
    ÅLAND_ISLANDS("ax","Åland Islands"),
    MONGOLIA("mn","Mongolia"),
    SPAIN("es","Spain"),
    LATVIA("lv","Latvia"),
    SINT_MAARTEN("sx","Sint Maarten"),
    PHILIPPINES("ph","Philippines"),
    UNITED_STATES_MINOR_OUTLYING_ISLANDS("um","United States Minor Outlying Islands"),
    VIET_NAM("vn","Viet Nam"),
    SAINT_BARTHÉLEMY("bl","Saint Barthélemy"),
    GAMBIA("gm","Gambia"),
    KOREA_R("kr","Korea"),
    TRINIDAD_AND_TOBAGO("tt","Trinidad and Tobago"),
    NICARAGUA("ni","Nicaragua"),
    ANDORRA("ad","Andorra"),
    ANGOLA("ao","Angola"),
    SOUTH_SUDAN("ss","South Sudan"),
    HONDURAS("hn","Honduras"),
    POLAND("pl","Poland"),
    MONTSERRAT("ms","Montserrat"),
    DOMINICA("dm","Dominica"),
    BOUVET_ISLAND("bv","Bouvet Island"),
    BELGIUM("be","Belgium"),
    CHILE("cl","Chile"),
    INDIA("in","India"),
    JORDAN("jo","Jordan"),
    CONGO_G("cg","Congo"),
    SWEDEN("se","Sweden"),
    CANADA("ca","Canada"),
    GUYANA("gy","Guyana"),
    LEBANON("lb","Lebanon"),
    VENEZUELA("ve","Venezuela"),
    ZAMBIA("zm","Zambia"),
    GHANA("gh","Ghana"),
    MONTENEGRO("me","Montenegro"),
    ARGENTINA("ar","Argentina"),
    BOLIVIA("bo","Bolivia"),
    MEXICO("mx","Mexico"),
    KOREA_P("kp","Korea"),
    SOLOMON_ISLANDS("sb","Solomon Islands"),
    UGANDA("ug","Uganda"),
    CHRISTMAS_ISLAND("cx","Christmas Island"),
    NORFOLK_ISLAND("nf","Norfolk Island"),
    CAMBODIA("kh","Cambodia"),
    SERBIA("rs","Serbia"),
    FRENCH_GUIANA("gf","French Guiana"),
    UZBEKISTAN("uz","Uzbekistan"),
    KAZAKHSTAN("kz","Kazakhstan"),
    ARUBA("aw","Aruba"),
    SENEGAL("sn","Senegal"),
    BARBADOS("bb","Barbados"),
    ESWATINI("sz","Eswatini"),
    ESTONIA("ee","Estonia"),
    FIJI("fj","Fiji"),
    AFGHANISTAN("af","Afghanistan"),
    WALLIS_AND_FUTUNA("wf","Wallis and Futuna"),
    SOUTH_GEORGIA_AND_THE_SOUTH_SANDWICH_ISLANDS("gs","South Georgia and the South Sandwich Islands"),
    BULGARIA("bg","Bulgaria"),
    BAHAMAS("bs","Bahamas"),
    MALI("ml","Mali"),
    RWANDA("rw","Rwanda"),
    CYPRUS("cy","Cyprus"),
    SYRIAN_ARAB_REPUBLIC("sy","Syrian Arab Republic"),
    TANZANIA("tz","Tanzania"),
    BOTSWANA("bw","Botswana"),
    TONGA("to","Tonga"),
    HEARD_ISLAND_AND_MCDONALD_ISLANDS("hm","Heard Island and McDonald Islands"),
    ZIMBABWE("zw","Zimbabwe"),
    IRELAND("ie","Ireland"),
    LIECHTENSTEIN("li","Liechtenstein"),
    PUERTO_RICO("pr","Puerto Rico"),
    ERITREA("er","Eritrea"),
    YEMEN("ye","Yemen"),
    FRENCH_SOUTHERN_TERRITORIES("tf","French Southern Territories"),
    COCOS_KEELING_ISLANDS("cc","Cocos (Keeling) Islands"),
    MYANMAR("mm","Myanmar"),
    MAURITANIA("mr","Mauritania"),
    KYRGYZSTAN("kg","Kyrgyzstan"),
    TURKS_AND_CAICOS_ISLANDS("tc","Turks and Caicos Islands"),
    PALAU("pw","Palau"),
    GEORGIA("ge","Georgia"),
    ECUADOR("ec","Ecuador"),
    SAUDI_ARABIA("sa","Saudi Arabia"),
    SAO_TOME_AND_PRINCIPE("st","Sao Tome and Principe"),
    MONACO("mc","Monaco"),
    ITALY("it","Italy"),
    GREENLAND("gl","Greenland"),
    UNITED_ARAB_EMIRATES("ae","United Arab Emirates"),
    PAKISTAN("pk","Pakistan"),
    LITHUANIA("lt","Lithuania"),
    IRAQ("iq","Iraq"),
    TURKEY("tr","Turkey"),
    FALKLAND_ISLANDS("fk","Falkland Islands"),
    TOGO("tg","Togo"),
    MALAYSIA("my","Malaysia"),
    NIGERIA("ng","Nigeria"),
    KUWAIT("kw","Kuwait"),
    AMERICAN_SAMOA("as","American Samoa"),
    SINGAPORE("sg","Singapore"),
    LAO_PEOPLES_DEMOCRATIC_REPUBLIC("la","Lao People's Democratic Republic"),
    KIRIBATI("ki","Kiribati"),
    BHUTAN("bt","Bhutan"),
    BAHRAIN("bh","Bahrain"),
    MAURITIUS("mu","Mauritius"),
    TUNISIA("tn","Tunisia"),
    ISLE_OF_MAN("im","Isle of Man"),
    PALESTINE("ps","Palestine"),
    ANTIGUA_AND_BARBUDA("ag","Antigua and Barbuda"),
    SWITZERLAND("ch","Switzerland"),
    GUERNSEY("gg","Guernsey"),
    ETHIOPIA("et","Ethiopia"),
    TOKELAU("tk","Tokelau"),
    BRUNEI_DARUSSALAM("bn","Brunei Darussalam"),
    SRI_LANKA("lk","Sri Lanka"),
    ALGERIA("dz","Algeria"),
    SAINT_MARTIN("mf","Saint Martin"),
    NEW_ZEALAND("nz","New Zealand"),
    COOK_ISLANDS("ck","Cook Islands"),
    GUATEMALA("gt","Guatemala"),
    RÉUNION("re","Réunion"),
    HAITI("ht","Haiti"),
    ARMENIA("am","Armenia"),
    MARTINIQUE("mq","Martinique"),
    CONGO_D("cd","Congo"),
    UNITED_STATES_OF_AMERICA("us","United States of America"),
    BENIN("bj","Benin"),
    GUADELOUPE("gp","Guadeloupe"),
    PAPUA_NEW_GUINEA("pg","Papua New Guinea"),
    NAURU("nr","Nauru"),
	SAN_MARINO("sm","San Marino"),
    PARAGUAY("py","Paraguay"),
    FRANCE("fr","France"),
    COLOMBIA("co","Colombia"),
    SVALBARD_AND_JAN_MAYEN("sj","Svalbard and Jan Mayen"),
    DJIBOUTI("dj","Djibouti"),
    AZERBAIJAN("az","Azerbaijan"),
    GERMANY("de","Germany"),
	VIRGIN_ISLANDS_US("vi","Virgin Islands (U.S.)"),
    ANGUILLA("ai","Anguilla"),
    CUBA("cu","Cuba"),
    PITCAIRN("pn","Pitcairn"),
    NEW_CALEDONIA("nc","New Caledonia"),
    GRENADA("gd","Grenada"),
    SAINT_VINCENT_AND_THE_GRENADINES("vc","Saint Vincent and the Grenadines"),
    TUVALU("tv","Tuvalu"),
    KENYA("ke","Kenya"),
    NIGER("ne","Niger"),
    TAIWAN("tw","Taiwan"),
    BANGLADESH("bd","Bangladesh"),
    REPUBLIC_OF_NORTH_MACEDONIA("mk","Republic of North Macedonia"),
    AUSTRALIA("au","Australia"),
    BONAIRE("bq","Bonaire"),
	EL_SALVADOR("sv","El Salvador"),
    MALDIVES("mv","Maldives"),
    TURKMENISTAN("tm","Turkmenistan"),
    MOLDOVA("md","Moldova"),
    CABO_VERDE("cv","Cabo Verde"),
    THAILAND("th","Thailand"),
    ROMANIA("ro","Romania"),
    JAMAICA("jm","Jamaica"),
    LIBYA("ly","Libya"),
    OMAN("om","Oman"),
    NAMIBIA("na","Namibia"),
    PORTUGAL("pt","Portugal"),
    IRAN("ir","Iran"),
    MOZAMBIQUE("mz","Mozambique"),
    SAINT_HELENA("sh","Saint Helena"),
    MADAGASCAR("mg","Madagascar"),
    GUAM("gu","Guam"),
    BERMUDA("bm","Bermuda"),
    HOLY_SEE("va","Holy See"),
    ALBANIA("al","Albania"),
    QATAR("qa","Qatar"),
    CÔTE_D_IVOIRE("ci","Côte d'Ivoire"),
    LUXEMBOURG("lu","Luxembourg"),
    PERU("pe","Peru"),
    NETHERLANDS("nl","Netherlands"),
    ISRAEL("il","Israel"),
    SEYCHELLES("sc","Seychelles"),
    SIERRA_LEONE("sl","Sierra Leone"),
    NEPAL("np","Nepal"),
    MAYOTTE("yt","Mayotte"),
    EQUATORIAL_GUINEA("gq","Equatorial Guinea"),
    BURUNDI("bi","Burundi"),
    DENMARK("dk","Denmark"),
    SAINT_PIERRE_AND_MIQUELON("pm","Saint Pierre and Miquelon"),
    CAYMAN_ISLANDS("ky","Cayman Islands"),
    SAINT_KITTS_AND_NEVIS("kn","Saint Kitts and Nevis"),
    CHINA("cn","China"),
    MICRONESIA("fm","Micronesia"),
    MACAO("mo","Macao"),
    GUINEA_BISSAU("gw","Guinea-Bissau"),
    PANAMA("pa","Panama"),
    BELIZE("bz","Belize"),
    NORTHERN_MARIANA_ISLANDS("mp","Northern Mariana Islands"),
    RUSSIAN_FEDERATION("ru","Russian Federation"),
    EGYPT("eg","Egypt"),
    SOUTH_AFRICA("za","South Africa"),
    MOROCCO("ma","Morocco"),
    HONG_KONG("hk","Hong Kong"),
    AUSTRIA("at","Austria"),
    CHAD("td","Chad"),
    HUNGARY("hu","Hungary"),
    SAINT_LUCIA("lc","Saint Lucia"),
    COSTA_RICA("cr","Costa Rica"),
    DOMINICAN_REPUBLIC("do","Dominican Republic"),
    UKRAINE("ua","Ukraine"),
    DESCONOCIDO("un","Desconocido");

	private String id;
	private String name;
    
	CountryEnum(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
    public static List<CountryEnum> getAllCountries() {
    	
    	List<CountryEnum> allCountries = Arrays.stream(CountryEnum.values()).collect(Collectors.toList());
    	
    	return allCountries;//(CountryEnum[]) allCountries.toArray(new CountryEnum[allCountries.size()]);
    }

    public static CountryEnum getCountry(String countryId) {
		List<CountryEnum> countryEnum = CountryEnum.getAllCountries();
		for (CountryEnum ce : countryEnum) {
			if(ce.getId().equals(countryId))
				return ce;
		}
		return null;
	}

}
