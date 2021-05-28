const urls = require("../urls.json");
const axios = require("axios");

const requester = axios.create({
  baseURL: urls.base_url
});

module.exports = (location, query, cb) => {
  return new Promise((resolve, reject) => {
    requester.post(process.env.JOOBLE_API_KEY, {
      keywords: "pcd",
      location
    }).then(response => {
      const jobs = response.data.jobs.slice(0, 3);
      console.log(jobs);

      resolve(jobs);
    }).catch(err => {
      console.error(err);
      reject();
    })
  })
} 