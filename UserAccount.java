public class UserAccount
{
  private String     userFirstName;
  private boolean    isMale = false;
  private int        userAge;
  private int        userHeightInches;
  private int        userWeight;
  private int        userStartingWeight;
  private double     userBMR;
  private int        userLifestyle;
  private String     userID;
  private String     userPassword;
  private DateRecord userDateJoined;

  UserAccount(){}

  UserAccount(String _userFirstName, String _isMale, int _userAge, int _userHeightInches, int _userWeight,
    int _userStartingWeight, double _userBMR, int _userLifestyle, String _userID, String _userPassword, DateRecord _userDateJoined)
    {
      userFirstName      = _userFirstName;
      if (_isMale.equals("true"))
        isMale           = true;
      userAge            = _userAge;
      userHeightInches   = _userHeightInches;
      userWeight         = _userWeight;
      userStartingWeight = _userStartingWeight;
      userBMR            = _userBMR;
      userLifestyle      = _userLifestyle;
      userID             = _userID;
      userPassword       = _userPassword;
      userDateJoined     = _userDateJoined;
    }

  public String  getName()          { return userFirstName;    }
  public boolean getGender()        { return isMale;           }
  public int     getAge()           { return userAge;          }
  public int     getHeightInches()  { return userHeightInches; }
  public String  getHeightCompleteString()
  {
    int ByValUserHeightInches = userHeightInches;
    int userHeightFeet = ByValUserHeightInches / 12;
    ByValUserHeightInches = ByValUserHeightInches % 12;
    return userHeightFeet + "\'" + ByValUserHeightInches + "\"";
  } // End String getHeightCompleteString()

  public int    getWeight()         { return userWeight;         }
  public int    getStartingWeight() { return userStartingWeight; }
  public int    getLifestyle()      { return userLifestyle;      }
  public String getUserID()         { return userID;             }
  public String getPassword()       { return userPassword;       }
  public static String getLifestyleText(int _lifestyleIndex)
  {
    if (_lifestyleIndex == 1)
      return "Sedentary (little or no exercise)";
    else if (_lifestyleIndex == 2)
      return "Lightly active (light exercise/sports 1-3 days/week)";
    else if (_lifestyleIndex == 3)
      return "Moderately active (moderate exercise/sports 3-5 days/week)";
    else if (_lifestyleIndex == 4)
      return "Very active (hard exercise/sports 6-7 days a week)";
    else if (_lifestyleIndex == 5)
      return "Extra active (very hard exercise/sports & physical job or 2x training)";
    else
      return "Error";
  }

  public DateRecord getDateJoined() { return userDateJoined; }
  public long   getJoined()          { return userDateJoined.getUserJoined(); }
  public String getJoinedDayOfWeek() { return userDateJoined.getDayOfWeek();  }
  public String getJoinedMonth()     { return userDateJoined.getUserMonth();  }
  public String getJoinedDay()       { return userDateJoined.getUserDay();    }
  public String getJoinedYear()      { return userDateJoined.getUserYear();   }
  public Long   getLastLogin()       { return userDateJoined.getLastLogin();  }
  public String getJoinedFullPrint()
  {
    return getJoinedDayOfWeek() + " " + getJoinedMonth() + "/" + getJoinedDay() + "/" + getJoinedYear();
  } // end String getJoinedFullPrint

  public void setLastLogin(long _lastLogin) { userDateJoined.setLastLogin(_lastLogin); }
  private void calculateBMR()
  {
    if (isMale)
      userBMR = 66 + (6.23 * userWeight) + (12.7 * userHeightInches) - (6.8 * userAge);
    else
      userBMR = 655 + (4.35 * userWeight) + (4.7 * userHeightInches) - (4.7 * userAge);
  } // End void calculateBMR()

  public double getBMR()
  {
    calculateBMR();
    return userBMR;
  } // End double getBMR()

  public void setName(String _newProfileName)  { userFirstName    = _newProfileName;   }
  public void setAge(int _newProfileAge)       { userAge          = _newProfileAge;    }
  public void setHeight(int _newProfileHeight) { userHeightInches = _newProfileHeight; }
  public void setWeight(int _newProfileWeight) { userWeight       = _newProfileWeight; }
  public void setLifestyle(int _newLifestyle)  { userLifestyle    = _newLifestyle;     }
  public void setUsername(String _newUsername) { userID           = _newUsername;      }
  public void setPassword(String _newPassword) { userPassword     = _newPassword;      }
}
