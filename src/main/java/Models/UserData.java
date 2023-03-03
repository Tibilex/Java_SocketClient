package Models;
public class UserData {
    private User _user;
    private boolean _registrationStatus;

    public UserData() {
        _user = null;
        _registrationStatus = false;
    }

    public UserData(User user, boolean status) {
        this._user = user;
        this._registrationStatus = status;
    }

    public User get_user() {
        return _user;
    }

    public void set_user(User _user) {
        this._user = _user;
    }

    public boolean is_registrationStatus() {
        return _registrationStatus;
    }

    public void set_registrationStatus(boolean _registrationStatus) {
        this._registrationStatus = _registrationStatus;
    }

    @Override
    public String toString() {
        return "Usr{" + "User='" + _user + '\'' +
                ",isReg='" + _registrationStatus + '\'' +
                '}';
    }
}
