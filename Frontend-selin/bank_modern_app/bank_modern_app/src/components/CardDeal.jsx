import { card } from "../assets";
import styles, { layout } from "../style";
import Button from "./Button";

const CardDeal = () => (
  <section className={layout.section}>
    <div className={layout.sectionInfo}>
      <h2 className={styles.heading2}>
        Size uygun en iyi kartı seçin. <br className="sm:block hidden" /> Kişiye özel tasarımlarımız bulunuyor.
      </h2>
      <p className={`${styles.paragraph} max-w-[470px] mt-5`}>
        Seçeceğiniz kart opsiyonlarıyla indirimleri kaçırmayın.
      </p>

      <Button styles={`mt-10`} />
    </div>

    <div className={layout.sectionImg}>
      <img src={card} alt="billing" className="w-[100%] h-[100%]" />
    </div>
  </section>
);

export default CardDeal;