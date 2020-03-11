package savedurls.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UrlVisitMetadata {

    int totalVisits;
    int desktopVisitCount;
    int mobileVisitCount;
    HashMap<String, Integer> browserTypeCount = new HashMap<>();
    HashMap<String, Integer> osTypeCount = new HashMap<>();

    public UrlVisitMetadata() {
    }

    public int getTotalVisits() {
        return totalVisits;
    }

    public void setTotalVisits(int totalVisits) {
        this.totalVisits = totalVisits;
    }

    public void addVisit() {
        this.totalVisits++;
    }

    public int getDesktopVisitCount() {
        return desktopVisitCount;
    }

    public void setDesktopVisitCount(int desktopVisitCount) {
        this.desktopVisitCount = desktopVisitCount;
    }

    public void addDesktopVisit(){
        this.desktopVisitCount++;
    }

    public int getMobileVisitCount() {
        return mobileVisitCount;
    }

    public void setMobileVisitCount(int mobileVisitCount) {
        this.mobileVisitCount = mobileVisitCount;
    }

    public void addMobileVisit() {
        this.mobileVisitCount++;
    }

    public HashMap<String, Integer> getBrowserTypeCount() {
        return browserTypeCount;
    }

    public void setBrowserTypeCount(HashMap<String, Integer> browserTypeCount) {
        this.browserTypeCount = browserTypeCount;
    }

    public void addBrowserTypeVisit(String browserName) {
        this.browserTypeCount.put(browserName, (this.browserTypeCount.getOrDefault(browserName, 0) + 1));
    }

    public HashMap<String, Integer> getOsTypeCount() {
        return osTypeCount;
    }

    public void setOsTypeCount(HashMap<String, Integer> osTypeCount) {
        this.osTypeCount = osTypeCount;
    }

    public void addOsTypeVisit(String osName) {
        this.osTypeCount.put(osName, (this.osTypeCount.getOrDefault(osName, 0) + 1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlVisitMetadata that = (UrlVisitMetadata) o;
        return totalVisits == that.totalVisits &&
                desktopVisitCount == that.desktopVisitCount &&
                mobileVisitCount == that.mobileVisitCount &&
                Objects.equals(browserTypeCount, that.browserTypeCount) &&
                Objects.equals(osTypeCount, that.osTypeCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalVisits, desktopVisitCount, mobileVisitCount, browserTypeCount, osTypeCount);
    }

    @Override
    public String toString() {
        int desktopPercentage = (desktopVisitCount + mobileVisitCount) == 0 ? 0 : (desktopVisitCount / (desktopVisitCount + mobileVisitCount));
        int mobilePercentage = (desktopVisitCount + mobileVisitCount) == 0 ? 0 : (mobileVisitCount / (desktopVisitCount + mobileVisitCount));
        return "Total Visits: " + totalVisits +
                ", " + desktopPercentage + "% of visits from desktop vs" +
                " " + mobilePercentage + "% of visits from mobile" +
                ", " + getPercentagePerTypeString(browserTypeCount) +
                ", " + getPercentagePerTypeString(osTypeCount);
    }

    private String getPercentagePerTypeString(HashMap<String, Integer> typeCountMap) {
        if(typeCountMap.isEmpty()) {
            return "";
        }
        int sum = typeCountMap.values().stream().mapToInt(val -> val).sum();

        String res = "";
        for (Map.Entry<String, Integer> entry: typeCountMap.entrySet()) {
            res +=  (entry.getValue() / sum) + "% of visits from " + entry.getKey();
        }
        return res;
    }
}
