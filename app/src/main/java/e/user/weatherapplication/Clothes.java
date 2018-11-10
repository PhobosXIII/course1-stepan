package e.user.weatherapplication;

import java.util.Objects;

public class Clothes {

        private long id;
        private String clothesType;
        private int tFrom;
        private int tTo;
        private String description;


        public Clothes (String clothesPart, int tFrom, int tTo, String description) {
            this(0 , clothesPart, tFrom, tTo, description);
        }

        public Clothes(long id, String clothesPart, int tFrom, int tTo, String description) {
            this.id = id;
            this.clothesType = clothesPart;
            this.tFrom = tFrom;
            this.tTo = tTo;
            this.description = description;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

    }
